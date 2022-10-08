package com.example.login;

import java.lang.reflect.Constructor;
import java.util.List;

public class       ParentModelClass {

    String tittle;
   List<ChildModelClass> childModelClasses;

   public ParentModelClass(String tittle,List<ChildModelClass> childModelClasses) {
       this.tittle =tittle;
       this.childModelClasses= childModelClasses;
   }

}
