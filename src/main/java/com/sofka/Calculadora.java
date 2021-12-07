package com.sofka;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Calculadora {

    static final IntBinaryOperator sumar = (a, b) -> a + b;
    static final IntBinaryOperator restar = (a, b) -> a - b;
    static final IntBinaryOperator multiplicar= (a, b)-> {
        return IntStream.range(0, Math.abs(b) + 1)
                .reduce((acomulado, numero) -> sumar
                        .applyAsInt(Math.abs(a), acomulado))
                .getAsInt();


    };
    static final IntBinaryOperator dividir = (a,b) -> {
        return IntStream.range(0,Math.abs(a) )
                .reduce((acumulador, numero) ->
                        multiplicar.applyAsInt(numero, b) <= a ? sumar.applyAsInt(acumulador, 1) : acumulador).getAsInt();

    };

    public static void main(String[] args) {
        System.out.println(sumar.applyAsInt(50,90));
        System.out.println(restar.applyAsInt(30,25));
        System.out.println(multiplicar.applyAsInt(20,2));
        System.out.println(dividir.applyAsInt(60,5));
    }
}