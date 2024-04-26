
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RFCGeneratorTest {
    @Test
    public void testGenerateRFC() {
        String rfc = RFCGenerator.generateRFC("Juan Perez Lopez", "01-01-2000");
        assertEquals("PELJ000101", rfc);
    }
}