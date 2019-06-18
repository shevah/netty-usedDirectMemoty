package com.nettyreproduce.app;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test1(){
        PooledByteBufAllocator alloc = new PooledByteBufAllocator(true, 1, 1, 8192, 11, 0, 0, 0);
        ByteBuf b = alloc.buffer(3000000, 3000000);
        b.release();

        System.out.println("test1 usedDirectMemory:" + alloc.metric().usedDirectMemory());
    }

    private static void test2(){
        PooledByteBufAllocator alloc = new PooledByteBufAllocator(true, 1, 1, 8192, 11, 0, 0, 0);
        ByteBuf b = alloc.buffer(1000000, 1000000);
        b.release();

        System.out.println("test2 usedDirectMemory:" + alloc.metric().usedDirectMemory());
    }

    private static void test3(){
        PooledByteBufAllocator alloc = new PooledByteBufAllocator(true);
        ByteBuf b = alloc.buffer(3000000, 3000000);
        b.release();

        System.out.println("test3 usedDirectMemory:" + alloc.metric().usedDirectMemory());
    }

    private static void test4(){
        PooledByteBufAllocator alloc = new PooledByteBufAllocator(true);
        ByteBuf b = alloc.buffer(1000000, 1000000);
        b.release();

        System.out.println("test4 usedDirectMemory:" + alloc.metric().usedDirectMemory());
    }

    private static void test5(){
        UnpooledByteBufAllocator alloc = new UnpooledByteBufAllocator(true);
        ByteBuf b = alloc.buffer(3000000, 3000000);
        b.release();

        System.out.println("test5 usedDirectMemory:" + alloc.metric().usedDirectMemory());
    }

    private static void test6(){
        UnpooledByteBufAllocator alloc = new UnpooledByteBufAllocator(true);
        ByteBuf b = alloc.buffer(1000000, 1000000);
        b.release();

        System.out.println("test6 usedDirectMemory:" + alloc.metric().usedDirectMemory());
    }
}
