package com.wanji.etcxobu.websocket.entity;

import lombok.Data;

@Data
public class Frametype {

    private int frametype;

    public Frametype(int frametype) {
        this.frametype = frametype;
    }
}
