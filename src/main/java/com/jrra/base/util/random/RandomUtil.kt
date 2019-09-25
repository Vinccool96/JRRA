package com.jrra.base.util.random

import java.util.*

object RandomUtil {

    fun randomString(size: Int): String {
        val chars = ("_,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T," +
                "U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r," +
                "s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9").split(",")
        return randomString(chars, size)
    }

    fun randomString(characters: List<String>, size: Int): String {
        val stringBuilder = StringBuilder()
        while (stringBuilder.length < size) {
            stringBuilder.append(characters[random(characters.size - 1)])
        }
        return stringBuilder.toString()
    }

    fun random(lower: Int, upper: Int): Int {
        val bound = upper - lower + 1
        return Random().nextInt(bound) + lower
    }

    fun random(upper: Int): Int {
        return random(0, upper)
    }
}