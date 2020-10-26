package com.example.deserialization.springdeserializationdemo.Models;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class BoardState implements Serializable {
    private String id;
    private byte[] boardState;

    public BoardState(String id, byte[] boardState) {
        this.id = id;
        this.boardState = boardState;
    }

    @Override
    protected void finalize() throws Throwable {
        saveBoardState();
        super.finalize();
    }

    private void saveBoardState() throws IOException {
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(id + ".boardstate"));
        writer.write(boardState);
        writer.close();
    }
}
