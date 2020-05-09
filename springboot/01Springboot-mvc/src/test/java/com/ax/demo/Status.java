package com.ax.demo;

public enum Status {
    NEW(0) {
      @Override
      void run() {
        //do something
          System.out.println("NEW");
      }
    },
    RUNNABLE(1) {
      @Override
       void run() {
         //do something
          System.out.println("RUNNABLE");
      }
    },


    ;



    private int statusCode;

    abstract void run();

    Status(int statusCode){
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static Status valueOf(int value) {
//        switch (value) {
//            case 0:
//                return Status.NEW;
//            case 1:
//                return Status.RUNNABLE;
//            default:
//                return null;
//        }

        for (Status type : Status.values()) {
            if (type.getStatusCode() == value) {
                return type;
            }
        }
        return null;
    }


}