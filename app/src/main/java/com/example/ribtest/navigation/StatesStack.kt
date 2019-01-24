package com.example.ribtest.navigation

import android.os.Parcel
import android.os.Parcelable

class StatesStack() : Parcelable {

    public val stack:MutableList<States> = mutableListOf()

    constructor(parcel: Parcel) : this() {
        parcel.readList(stack, null)
    }

    fun addState(state: States){
        stack.add(state)
    }

    fun removeState(state: States){
        stack.remove(state)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeList(stack)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StatesStack> {
        override fun createFromParcel(parcel: Parcel): StatesStack {
            return StatesStack(parcel)
        }

        override fun newArray(size: Int): Array<StatesStack?> {
            return arrayOfNulls(size)
        }
    }

}