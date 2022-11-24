package com.example.login;

import java.util.List;

public class MusicGroup {

    String tittle;
    List<Song> childModelClassList;

   public MusicGroup(String tittle, List<Song> childModelClasses) {
       this.tittle = tittle;
       this.childModelClassList= childModelClasses;
   }

}
