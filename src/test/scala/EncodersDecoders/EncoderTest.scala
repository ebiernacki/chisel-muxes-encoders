package EncodersDecoders


import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec



class EncoderTest extends AnyFlatSpec with ChiselScalatestTester {

    "One Hot Encoder" should s"encode 2:4" in {
        test(new Encoder) { dut =>
            dut.io.input.poke("b0001".U) 
            dut.io.output.expect(0.U) 

            dut.io.input.poke("b0010".U)
            dut.io.output.expect(1.U) 

            dut.io.input.poke("b0100".U) 
            dut.io.output.expect(2.U) 

            dut.io.input.poke("b1000".U) 
            dut.io.output.expect(3.U) 

            dut.io.input.poke("b1000".U) 
            dut.io.output.expect(3.U) 
            
        }
    }


    //Below is the test cases for the Priority Encoder. 
    //Given the first poke and expect, what can you infer about the bit priority and direction?
    //Answer Here:


    //Write in the rest of the expect statement for each poke value in the test below
    
    "Priority Encoder" should "encode the highest-priority input correctly" in {
        test(new PriorityEncoderExample) { dut =>

            dut.io.input.poke("b1000".U) 
            dut.io.output.expect(3.U)
            
            dut.io.input.poke("b0100".U) 
            
            
            dut.io.input.poke("b0010".U) 
             

            dut.io.input.poke("b0001".U) 
            
            
            dut.io.input.poke("b1010".U) 
             

            dut.io.input.poke("b0101".U) 
            
            
            dut.io.input.poke("b0110".U) 


            dut.io.input.poke("b1111".U) 


            dut.io.input.poke("b1100".U) 
            
            
        }
    }
}