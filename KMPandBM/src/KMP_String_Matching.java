import java.util.HashSet;

class KMP_String_Matching {
    boolean check(String pat, String txt)
    {
        boolean flag = true;
        for(int i =0; i<pat.length(); i++) {
            if (pat.charAt(i) != 'A' && pat.charAt(i) != 'C' && pat.charAt(i) != 'G' && pat.charAt(i) != 'T')
                flag = false;
        }
        for(int j =0; j<pat.length(); j++) {
            if (txt.charAt(j) != 'A' && txt.charAt(j) != 'C' && txt.charAt(j) != 'G' && txt.charAt(j) != 'T')
                flag = false;
        }
        return flag;
    }
    void KMPSearch(String pat, String txt)
    {
        if(check(pat, txt)) {
            int M = pat.length();
            int N = txt.length();
            int counter = 0;
            // create lps[] that will hold the longest
            // prefix suffix values for pattern
            int lps[] = new int[M];
            int j = 0; // index for pat[]

            // Preprocess the pattern (calculate lps[]
            // array)
            computeLPSArray(pat, M, lps);

            int i = 0; // index for txt[]
            while (i < N) {
                if (pat.charAt(j) == txt.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == M) {
                    System.out.println("Found pattern "
                            + "at index " + (i - j));
                    counter++;
                    j = lps[j - 1];
                }

                // mismatch after j matches
                else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                    if (j != 0)
                        j = lps[j - 1];
                    else
                        i = i + 1;
                }
            }
            System.out.println("Amount: " + counter);
        }
        else
            System.out.println("Wrong symbols!");
    }

    void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        long m = System.currentTimeMillis();
        String txt = "AAAA";
        String pat = "GTCA";
        new KMP_String_Matching().KMPSearch(pat, txt);
        System.out.println("Time in seconds: "+((double) (System.currentTimeMillis() - m))/1000);
    }
}