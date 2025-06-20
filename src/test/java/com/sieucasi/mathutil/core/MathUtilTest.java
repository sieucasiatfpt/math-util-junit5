/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */
package com.sieucasi.mathutil.core;

import static com.sieucasi.mathutil.core.MathUtil.*;
//import static là dành riêng cho những hàm static
//gọi hàm mà bỏ qua tên class


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author SieuCaSi
 */
public class MathUtilTest {
    //chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này vào trong câu lệnh kiểm thử 
    
    //chuẩn bị bộ data
    public static Object[] [] initData() {
        return new Integer [] [] {
            {1, 1}, {2, 2}, {5, 120}, {6, 7120}
        };
    }
    @ParameterizedTest
    @MethodSource(value = "initData") //Tên hàm cung cấp data, nhầm định thứ tự của các phần tử mảng, ma vào tham số hàm
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected){
        Assertions.assertEquals(expected, getFactorial(input));
    }
//    @Test
//    public void testGetFactorialGivenRightArgReturnWell(){
//        Assertions.assertEquals(120, getFactorial(5));
//    }
    
    //Bắt ngoại lệ khi đưa data sai!
//    @Test（expect - tện ngoại lên.class) Junit 4, Junit 5 khác
    @Test
    public void testGetFactoialGivenWrongArgThrowException(){
        //xài biểu thức Lambda 
        //hàm nhận tham số thứ 2 là 1 cái object/có code implement cái functional interface tên là Excecutable - có 1 hàm duy nhất ko code
        //tên là excutable()
        //chơi chậm
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//
//            }
//        }; //khúc này là khai báo biến nên cần có ";"

//        Executable exObject = () -> getFactorial(-5); //khúc này là khai báo biến nên cần có ";"


        Assertions.assertThrows(IllegalArgumentException.class, () -> getFactorial(-5)/* khúc này là tham số nên ko cần có ";" */); 
    }
}
