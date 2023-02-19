package com.fufn.task.service;

import com.fufn.task.entity.Code;
import com.fufn.task.repository.CodeRepository;
import com.fufn.task.service.impl.CodeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CodeServiceImplTest {
    @Mock
    private CodeRepository codeRepository;
    @InjectMocks
    private CodeServiceImpl codeService;

    @Test
    void givenCode_whenBorder_z9z9() {

        //given
        Code code = new Code();
        code.setId(1L);
        code.setCode("z9z9");

        Code expected = new Code();
        expected.setCode("a0a0a0");

        //when

        when(codeRepository.findTopByOrderByIdDesc()).thenReturn(code);
        when(codeRepository.save(any())).thenReturn(null);

        Code code1 = codeService.getCode();

        //then

        Assertions.assertEquals(code1.getCode(), "z9z9");
        verify(codeRepository).save(expected);

    }

    @Test
    void givenCode_whenNotBorder_z9z9z8() {

        //given
        Code code = new Code();
        code.setId(1L);
        code.setCode("z9z9z8");

        Code expected = new Code();
        expected.setCode("z9z9z9");

        //when

        when(codeRepository.findTopByOrderByIdDesc()).thenReturn(code);
        when(codeRepository.save(any())).thenReturn(null);

        Code code1 = codeService.getCode();

        //then

        Assertions.assertEquals(code1.getCode(), "z9z9z8");
        verify(codeRepository).save(expected);

    }

    @Test
    void givenCode_whenBorder_a0z9() {

        //given
        Code code = new Code();
        code.setId(1L);
        code.setCode("a0z9");

        Code expected = new Code();
        expected.setCode("a1a0");

        //when

        when(codeRepository.findTopByOrderByIdDesc()).thenReturn(code);
        when(codeRepository.save(any())).thenReturn(null);

        Code code1 = codeService.getCode();

        //then

        Assertions.assertEquals(code1.getCode(), "a0z9");
        verify(codeRepository).save(expected);

    }

    @Test
    void givenCode_whenBorder_w9z9() {

        //given
        Code code = new Code();
        code.setId(1L);
        code.setCode("y9z9");

        Code expected = new Code();
        expected.setCode("z0a0");

        //when

        when(codeRepository.findTopByOrderByIdDesc()).thenReturn(code);
        when(codeRepository.save(any())).thenReturn(null);

        Code code1 = codeService.getCode();

        //then

        Assertions.assertEquals(code1.getCode(), "y9z9");
        verify(codeRepository).save(expected);

    }
}
