package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpression {  //clasa utilitara care va tine pointcut expressions

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}


    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")  //pointcut pt getter
    public void getter(){}


    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")  //pointcut pt setter
    public void setter(){}


    @Pointcut("forDaoPackage() && !(getter() || setter())") // pt toate metodele din pachetul com.luv2code.aopdemo.dao fara getter si setter
    public void forDaoPackageNoGetterSetter(){}



}
