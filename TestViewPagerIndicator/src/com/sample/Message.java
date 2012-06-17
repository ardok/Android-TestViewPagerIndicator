package com.sample;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This is just a simple class to demonstrate putParcelable into a Bundle
 * @author ardokusuma
 *
 */
public class Message implements Parcelable {
	private String message;
	
	public Message() {
		message = "";
	}
	
	public Message(String msg) {
		message = msg;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String msg) {
		message = msg;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(message);
	}
	
//	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
//        public Message createFromParcel(Parcel in) {
//        	final Message m = new Message();
//        	m.setMessage((String) in.readValue(Message.class.getClassLoader()));
//        	return m;
//        }
//        
//        public Message[] newArray(int size) { 
//        	throw new UnsupportedOperationException();
//        }
//    };
}
