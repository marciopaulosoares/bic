package br.com.marciopaulo.bic.helpers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marci on 30/12/2016.
 */

public class ConverterHelper {

    public static int[] toIntArray(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
