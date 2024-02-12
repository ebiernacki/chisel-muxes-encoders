package EncodersDecoders

import chisel3._
import chisel3.util._
import upickle.default

class Encoder() extends Module { 
    val io = IO(new Bundle {
        val  a = Input(UInt(4.W))
        val  b = Output(UInt(2.W))
    })

    io.b := 0.U
    //using switch statement
    switch (io.a) {
        is ("b0001".U) { io.b := "b00".U}
        is ("b0010".U) { io.b := "b01".U}
        is ("b0100".U) { io.b := "b10".U}
        is ("b1000".U) { io.b := "b11".U}
    }

}