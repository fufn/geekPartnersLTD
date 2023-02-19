package com.fufn.task.service.impl;

import com.fufn.task.entity.Code;
import com.fufn.task.repository.CodeRepository;
import com.fufn.task.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {

    private final CodeRepository codeRepository;
    private final Logger logger = LogManager.getLogger(getClass());

    @Override
    public Code getCode(){
        logger.debug("getting last code");
        Code code = codeRepository.findTopByOrderByIdDesc();
        generateNewCode(code.getCode());
        return code;
    }

    private void generateNewCode(String curCode) {
        logger.debug("generating new Code");
        StringBuilder sb = new StringBuilder(curCode);
        int index = curCode.length()-1;
        while (index >= 0) {
            logger.debug("going through code + {}", sb.toString());
            char character = sb.charAt(index);
            if (Character.isDigit(character)){
                logger.debug("the character is digit");
                character++;
                if (character != ':'){
                    logger.debug("there is no need to increment next character");
                    sb.deleteCharAt(index);
                    sb.insert(index, character);
                    break;
                } else {
                    logger.debug("next character should be incremented, make current character to initial");
                    character = '0';
                    sb.deleteCharAt(index);
                    sb.insert(index, character);
                }
            } else {
                logger.debug("the character is char");
                character++;
                if (character != '{'){
                    logger.debug("there is no need to increment next character");
                    sb.deleteCharAt(index);
                    sb.insert(index, character);
                    break;
                } else{
                    logger.debug("next character should be incremented, make current character to initial");
                    character = 'a';
                    sb.deleteCharAt(index);
                    sb.insert(index, character);
                }
            }
            index--;
        }
        if (curCode.charAt(0) != 'a' && sb.charAt(0) == 'a'){
            logger.debug("New sequence should be generated because previous code reached the border");
            generateNewSequence(sb, curCode.length()/2);
        }
        Code code = new Code();
        code.setCode(sb.toString());
        logger.debug("saved {}", sb.toString());
        codeRepository.save(code);
    }

    private void generateNewSequence(StringBuilder sb, int prevSequencePairs){
        sb.delete(0, sb.length());
        int newSequencePairs = prevSequencePairs + 1;
        sb.append("a0".repeat(newSequencePairs));
    }

}
