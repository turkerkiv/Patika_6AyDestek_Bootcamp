package Week2;
import java.util.Arrays;

public class HarmonicMeanCalc {
    public static void main(String[] args) {

        int[] array = {5,1,34,5,1,2,4,6};

        double harmonicSeries = 0;

        for(int i = 0; i < array.length; i++)
        {
            harmonicSeries += (1d/array[i]);
        }

        double harmonicMean = array.length / harmonicSeries;
        System.out.print("Harmonic mean is: " + harmonicMean);
    }
}
