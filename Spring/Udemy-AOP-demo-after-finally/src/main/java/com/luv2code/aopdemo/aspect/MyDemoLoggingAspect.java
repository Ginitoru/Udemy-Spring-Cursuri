package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.util.GenericSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoiunt){
        String method = theJoinPoiunt.getSignature().toShortString();
        System.out.println("\n==========> Executing @After (finally) on method " + method);

    }


    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAdvice(JoinPoint theJoinPoint, Throwable theExc){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n==========> Executing @AfterThrowing on method " + method);

        System.out.println("THE EXCEPTION IS: " + theExc);
    }







//    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts())", returning = "result")
//    public void afterReturningFindAcounsAdvice(JoinPoint theJoinPoin, List<Account> result){
//
//        String method = theJoinPoin.getSignature().toShortString();
//        System.out.println("\n==========> Executing @AfterReturning on method " + method);
//
//        System.out.println("\n==========> result is: " + result);
//
//        convertAccountToUpperCase(result);
//
//        if(!result.isEmpty()){
//
//            Account account = result.get(0);
//
//            account.setName("duffy duck");
//        }
//
//
//    }
//
//    private void convertAccountToUpperCase(List<Account> result) {
//
//        result.forEach( e-> e.setName(e.getName().toUpperCase()));
//
//        System.out.println(result);
//    }


//    @Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
//    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
//
//        System.out.println("\n==========> Executing @Before advice on metod + xxxxx");
//
//        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature(); // semantura metodei
//
//        System.out.println("MetodSignature: " + methodSignature);
//
//        Object [] args = theJoinPoint.getArgs();
//
//        for(Object tempArg: args){
//
//            if(tempArg instanceof Account){
//                Account theAccount = (Account) tempArg;
//
//                System.out.println("account name: " + theAccount.getName());
//                System.out.println("account level: " + theAccount.getLevel());
//            }
//
//            System.out.println(tempArg);
//
//
//        }
//
//    }















}
