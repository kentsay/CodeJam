/**
 * 
 */
package com.yahoo.twshopping.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.yahoo.twshopping.codejam.ABCPath;

/**
 * Description of the class.
 *
 * @author $Id: kentsay$
 * @version $Revision: 1$
 *
 */
public class ABCPathTest {

    @Test
    public void testCase1()
    {
        String[] as = { "ABE",
                  "CFG",
                  "BDH",
                  "ABC" };
        ABCPath c = new ABCPath();
        assertEquals( 4, c.length(as) );
    }
    
    @Test
    public void testCase2()
    {
        String[] as = { "A" };
        ABCPath c = new ABCPath();
        assertEquals( 1, c.length(as) );
    }
    
    @Test
    public void testCase3()
    {
        String[] as = { "BCDEFGHIJKLMNOPQRSTUVWXYZ" };
        ABCPath c = new ABCPath();
        assertEquals( 0, c.length(as) );
    }
    
    @Test
    public void testCase4()
    {
        String[] as = { "C",
              "D",
              "B",
              "A" };
        ABCPath c = new ABCPath();
        assertEquals( 2, c.length(as) );
    }

    @Test
    public void testCase5()
    {
        String[] as = { "KCBVNRXSPVEGUEUFCODMOAXZYWEEWNYAAXRBKGACSLKYRVRKIO",
                  "DIMCZDMFLAKUUEPMPGRKXSUUDFYETKYQGQHNFFEXFPXNYEFYEX",
                  "DMFRPZCBOWGGHYAPRMXKZPYCSLMWVGMINAVRYUHJKBBRONQEXX",
                  "ORGCBHXWMTIKYNLFHYBVHLZFYRPOLLAMBOPMNODWZUBLSQSDZQ",
                  "QQXUAIPSCEXZTTINEOFTJDAOBVLXZJLYOQREADUWWSRSSJXDBV",
                  "PEDHBZOVMFQQDUCOWVXZELSEBAMBRIKBTJSVMLCAABHAQGBWRP",
                  "FUSMGCSCDLYQNIXTSTPJGZKDIAZGHXIOVGAZHYTMIWAIKPMHTJ",
                  "QMUEDLXSREWNSMEWWRAUBFANSTOOJGFECBIROYCQTVEYGWPMTU",
                  "FFATSKGRQJRIQXGAPLTSXELIHXOPUXIDWZHWNYUMXQEOJIAJDH",
                  "LPUTCFHYQIWIYCVOEYHGQGAYRBTRZINKBOJULGYCULRMEOAOFP",
                  "YOBMTVIKVJOSGRLKTBHEJPKVYNLJQEWNWARPRMZLDPTAVFIDTE",
                  "OOBFZFOXIOZFWNIMLKOTFHGKQAXFCRZHPMPKGZIDFNBGMEAXIJ",
                  "VQQFYCNJDQGJPYBVGESDIAJOBOLFPAOVXKPOVODGPFIYGEWITS",
                  "AGVBSRLBUYOULWGFOFFYAAONJTLUWRGTYWDIXDXTMDTUYESDPK",
                  "AAJOYGCBYTMXQSYSPTBWCSVUMNPRGPOEAVVBGMNHBXCVIQQINJ",
                  "SPEDOAHYIDYUJXGLWGVEBGQSNKCURWYDPNXBZCDKVNRVEMRRXC",
                  "DVESXKXPJBPSJFSZTGTWGAGCXINUXTICUCWLIBCVYDYUPBUKTS",
                  "LPOWAPFNDRJLBUZTHYVFHVUIPOMMPUZFYTVUVDQREFKVWBPQFS",
                  "QEASCLDOHJFTWMUODRKVCOTMUJUNNUYXZEPRHYOPUIKNGXYGBF",
                  "XQUPBSNYOXBPTLOYUJIHFUICVQNAWFMZAQZLTXKBPIAKXGBHXX" };
        ABCPath c = new ABCPath();
        assertEquals( 19, c.length(as) );
    }

    @Test
    public void testCase6()
    {
        String[] as = { "EDCCBA",
          "EDCCBA" };
        ABCPath c = new ABCPath();
        assertEquals( 3, c.length(as) );
    }
    
    @Test
    public void testCase7()
    {
        String[] as = { "AMNOPA",
                  "ALEFQR",
                  "KDABGS",
                  "AJCHUT",
                  "AAIWVA",
                  "AZYXAA" };
        ABCPath c = new ABCPath();
        assertEquals( 26, c.length(as) );
    }
}
