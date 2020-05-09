package com.ax.demo;

public enum Strategy {
    FAST {
      @Override
      void run() {
        //do something  
          System.out.println("FAST");
      }
    },
    NORMAL {
      @Override
       void run() {
         //do something
          System.out.println("NORMAL");
      }
    },

    SMOOTH {
      @Override
       void run() {
         //do something
          System.out.println("SMOOTH");
      }
    },

    SLOW {
      @Override
       void run() {
         //do something
          System.out.println("SLOW");
      }
    };
    abstract void run();

    public static Strategy valueOf(int value) {

        switch (value) {
            case 0:
                return Strategy.FAST;
            case 1:
                return Strategy.NORMAL;
            case 2:
                return Strategy.SMOOTH;
            case 3:
                return Strategy.SLOW;
            default:
                return null;
        }

//        for (Strategy type : Strategy.values()) {
//            if (type.name().equals()) {
//                return type;
//            }
//        }
//        return null;
    }



}