package EncodersDecoders


import chisel3._
import chisel3.experimental.BundleLiterals._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util.Random


class EncoderTest extends AnyFlatSpec with ChiselScalatestTester {

    "EncoderTest" should s"encode 1:4 " in {
        test(new Encoder) { dut =>
            dut.io.a.poke(1.U)
            
            dut.io.b.expect(0.U)
            
        }
    }
}