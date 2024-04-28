package info5100.number_recognition2.model;

import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.ndarray.FloatNdArray;
import org.tensorflow.ndarray.NdArrays;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.ndarray.buffer.DataBuffers;
import org.tensorflow.types.TFloat32;

import java.util.Arrays;
import java.util.List;

public class NumberRecognizer {
    private static final String MODEL_PATH = "mnist_model";
    private static final String INPUT_NAME = "input_1";
    private static final String OUTPUT_NAME = "dense_1/Softmax";
    private static final int IMAGE_SIZE = 28;
    private static final int NUM_CHANNELS = 1;

    private final SavedModelBundle model;

    public NumberRecognizer() {
        model = SavedModelBundle.load(MODEL_PATH, "serve");
    }

    public int recognizeNumber(float[][] image) {
        FloatNdArray floatNdArray = NdArrays.ofFloats(Shape.of(1, IMAGE_SIZE, IMAGE_SIZE, NUM_CHANNELS));
        for (int i = 0; i < IMAGE_SIZE; i++) {
            for (int j = 0; j < IMAGE_SIZE; j++) {
                floatNdArray.setFloat(image[i][j], 0, i, j, 0);
            }
        }

        try (Tensor input = TFloat32.tensorOf(floatNdArray);
             Session session = this.model.session()) {
            // Create the runner
            Session.Runner runner = session.runner();
            // Your code here to use the runner

            List<Tensor> outputs = runner.feed(INPUT_NAME, input)
                    .fetch(OUTPUT_NAME)
                    .run();
            try (Tensor output = outputs.get(0)) {
                if (output instanceof TFloat32 floatOutput) {
                    long outputSize = floatOutput.shape().size(0);
                    float[] predictions = new float[(int) outputSize];
                    floatOutput.read(DataBuffers.of(predictions));

                    return argmax(predictions);
                } else {
                    throw new IllegalStateException("Expected a TFloat32 tensor but received a different type.");
                }
            }
        }
    }

    private int argmax(float[] array) {
        int maxIndex = 0;
        float maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxIndex = i;
                maxValue = array[i];
            }
        }
        return maxIndex;
    }
}
