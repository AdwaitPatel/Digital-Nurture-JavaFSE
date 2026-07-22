import com.cognizant.exercise2.ExternalApi;
import com.cognizant.exercise2.MyService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        // Create Mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Inject Mock
        MyService service = new MyService(mockApi);

        // Call Method
        service.fetchData();

        // Verify Interaction
        verify(mockApi).getData();
    }
}