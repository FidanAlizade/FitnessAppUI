package com.example.fitnessappui;

import android.os.Parcel;
import android.os.Parcelable;

public class FitnessMove implements Parcelable {
    String fitnessName;
    String fitnessPicture;
    String fitnessDescription;
    int fitnessCalorie;

    public FitnessMove(String fitnessName, String fitnessPicture, String fitnessDescription, int fitnessCalorie) {
        this.fitnessName = fitnessName;
        this.fitnessPicture = fitnessPicture;
        this.fitnessDescription = fitnessDescription;
        this.fitnessCalorie = fitnessCalorie;
    }

    protected FitnessMove(Parcel in) {
        fitnessName = in.readString();
        fitnessPicture = in.readString();
        fitnessDescription = in.readString();
        fitnessCalorie = in.readInt();
    }

    public static final Creator<FitnessMove> CREATOR = new Creator<FitnessMove>() {
        @Override
        public FitnessMove createFromParcel(Parcel in) {
            return new FitnessMove(in);
        }

        @Override
        public FitnessMove[] newArray(int size) {
            return new FitnessMove[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getFitnessName() {
        return fitnessName;
    }

    public String getFitnessPicture() {
        return fitnessPicture;
    }

    public String getFitnessDescription() {
        return fitnessDescription;
    }

    public int getFitnessCalorie() {
        return fitnessCalorie;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fitnessName);
        parcel.writeString(fitnessPicture);
        parcel.writeString(fitnessDescription);
        parcel.writeInt(fitnessCalorie);
    }
}
