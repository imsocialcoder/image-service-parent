package nl.debijenkorf.imageservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@DisplayName("ImageService Tests")
class ImageServiceTest {

    @Mock
    private AWSS3Service awss3ServiceMock;

    @InjectMocks
    private ImageService imageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Retrieve Optimized Image Successfully")
    void getImage_Success() throws InterruptedException {
        String predefinedImageType = "thumbnail";
        String reference = "abc.jpg";
        byte[] expectedBytes = "exampleBytes".getBytes();
        when(awss3ServiceMock.getOptimizedImageFromStorage(predefinedImageType, reference)).thenReturn(expectedBytes);

        byte[] result = imageService.getImage(predefinedImageType, reference);

        assertArrayEquals(expectedBytes, result);
    }

    @Test
    @DisplayName("Flush Image Successfully")
    void flushImage_Success() {
        String predefinedImageType = "thumbnail";
        String reference = "reference.jpg";

        doNothing().when(awss3ServiceMock).flushImage(predefinedImageType, reference);
        imageService.flushImage(predefinedImageType, reference);

        verify(awss3ServiceMock, times(1)).flushImage(predefinedImageType, reference);
    }
}
