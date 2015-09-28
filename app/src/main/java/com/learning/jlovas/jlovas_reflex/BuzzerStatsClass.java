package com.learning.jlovas.jlovas_reflex;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jlovas on 9/27/15.
 */
public class BuzzerStatsClass implements Parcelable {

    private int twoPlayer1p;
    private int twoPlayer2p;

    //credit to implementing CREATOR:

    public static final Parcelable.Creator<BuzzerStatsClass> CREATOR = new Parcelable.Creator<BuzzerStatsClass>(){

        @Override
        public BuzzerStatsClass createFromParcel(Parcel in) {
            return new BuzzerStatsClass(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public BuzzerStatsClass[] newArray(int size) {
            return new BuzzerStatsClass[size];
        }
    };
    //constructor for the parcelable
    private BuzzerStatsClass(Parcel in){
        twoPlayer1p = in.readInt();
        twoPlayer2p = in.readInt();
    }

    public BuzzerStatsClass() {
        twoPlayer1p =0;
        twoPlayer2p=0;

    }

    public int getTwoPlayer1p() {
        return twoPlayer1p;

    }
    public int getTwoPlayer2p(){
        return twoPlayer2p;

    }

    public void increaseTwoPlayer1p(){
        twoPlayer1p++;
    }
    public void increaseTwoPlayer2p(){
        twoPlayer2p++;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int in) {
        parcel.writeInt(twoPlayer1p);
        parcel.writeInt(twoPlayer2p);
    }


}
