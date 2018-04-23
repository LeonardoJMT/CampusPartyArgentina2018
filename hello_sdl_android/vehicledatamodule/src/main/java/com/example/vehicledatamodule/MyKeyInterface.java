package com.example.vehicledatamodule;

import android.content.Context;

/**
 * Created by cvsmain on 3/21/18.
 */

public class MyKeyInterface {
    public MyKeyInterface(){};

    private String E911Override;

    public String getE911Override() {
        return E911Override;
    }

    public void setE911Override(String e911Override) {
        E911Override = e911Override;
    }
}
