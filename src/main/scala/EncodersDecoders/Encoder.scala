package EncodersDecoders

import chisel3._
import chisel3.util._

//Fill in the Encoder Module using the switch statement to encode a 4 bit signal to a 2 bit signal
//You can assume the input signal is a one hot encoded signal
class Encoder extends Module { 
    val io = IO(new Bundle {
        val input = Input(UInt(4.W))
        val output = Output(UInt(2.W))
    })


    
}


//TODO:
//Below is a module that uses the built in chisel method that creates a priority encoded output based on its input.
//To complete this assignment fill in the test cases and answer the questions in EncoderTest.scala

class PriorityEncoderExample extends Module {
    val io = IO(new Bundle {
        val input = Input(UInt(4.W))
        val output = Output(UInt(4.W))
    })

    // Implementing the priority encoder with the built in chisel method
    io.output := PriorityEncoder(io.input)

}