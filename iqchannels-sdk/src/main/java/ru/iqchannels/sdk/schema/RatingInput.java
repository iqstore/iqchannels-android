package ru.iqchannels.sdk.schema;

/**
 * Copyright iqstore.ru. All Rights Reserved.
 */
public class RatingInput {
    public int Value;
    public String Comment;

    public RatingInput() {}

    public RatingInput(int value) {
        this.Value = value;
    }
}
