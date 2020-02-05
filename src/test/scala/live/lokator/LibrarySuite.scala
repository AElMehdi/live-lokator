package live.lokator

import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite

@RunWith(classOf[JUnitPlatform])
class LibrarySuite extends AnyFunSuite {
  test("someMethod is always true") {
    assert(true)
  }
}
