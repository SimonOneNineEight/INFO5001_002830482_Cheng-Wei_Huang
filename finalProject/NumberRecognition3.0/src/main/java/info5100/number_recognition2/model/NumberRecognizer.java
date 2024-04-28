package info5100.number_recognition2.model;

import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.ndarray.FloatNdArray;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.ndarray.buffer.DataBuffer;
import org.tensorflow.ndarray.buffer.DataBuffers;
import org.tensorflow.ndarray.buffer.FloatDataBuffer;
import org.tensorflow.types.TFloat32;
import org.tensorflow.ndarray.NdArrays;
import org.tensorflow.ndarray.StdArrays;

import java.util.List;

public class NumberRecognizer {
    private static final String MODEL_DIR = "mnist_model";
    private static final String MODEL_TAG = "serve"; // Model tag used in saving the TensorFlow model
    private static final String INPUT_TENSOR_NAME = "input_1:0";
    private static final String OUTPUT_TENSOR_NAME = "dense_1/Softmax:0";

    private SavedModelBundle model;
    private Session session;

    public NumberRecognizer() {
        // Load the model
        model = SavedModelBundle.load(MODEL_DIR, MODEL_TAG);
        session = model.session();
    }

    public int recognizeNumber(float[][] image) {
        FloatNdArray floatNdArray = NdArrays.ofFloats(StdArrays.shapeOf(image));
        floatNdArray.write(StdArrays.copyFrom(createTensorFrom2DArray(image)));

        try (TFloat32 inputTensor = TFloat32.tensorOf(NdArrays.wrap(floatNdArray))) {
            List<Tensor> outputs = session.runner()
                    .feed(INPUT_TENSOR_NAME, inputTensor)
                    .fetch(OUTPUT_TENSOR_NAME)
                    .run();

            try (TFloat32 result = (TFloat32) outputs.get(0)) {
                float[] predictions = new float[(int) result.shape().size(1)];
                result.read((DataBuffer<Float>) NdArrays.vectorOf(predictions));
                return argmax(predictions);
            }
        }
    }

    private TFloat32 createTensorFrom2DArray(float[][] data) {
        Shape shape = Shape.of(data.length, data[0].length);
        FloatDataBuffer buffer = DataBuffers.ofFloats(shape.size());
        for (float[] row : data) {
            buffer.write(row);
        }
        return TFloat32.tensorOf(shape, buffer);
    }

    private int argmax(float[] predictions) {
        int maxIndex = 0;
        for (int i = 1; i < predictions.length; i++) {
            if (predictions[i] > predictions[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
