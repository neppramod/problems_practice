package array_01.operations;

public class MyArray {
    public char[] delete(char[] data, int pos)
    {
        if (pos >= 0 && pos < data.length) {
            char[] tmp = new char[data.length - 1];
            System.arraycopy(data, 0, tmp, 0, pos);
            System.arraycopy(data, pos + 1, tmp, pos, data.length - pos -1);
            return tmp;
        } else {
            return data;
        }
    }
}
