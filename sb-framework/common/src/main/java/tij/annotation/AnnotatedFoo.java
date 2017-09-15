package tij.annotation;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/9/15.
 */
public class AnnotatedFoo {

    @UseCase
    public void fn0(){}

    @UseCase(id = 123, description = "描述信息")
    public void fn1(){}

    public void fn2(){}

    public static void main(String[] args) {
        Method methods[] =AnnotatedFoo.class.getDeclaredMethods();
        for (Method m : methods) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc!=null){
                System.out.printf("id:%d,desc:%s\n",uc.id(), uc.description());
            }
        }
    }

}
