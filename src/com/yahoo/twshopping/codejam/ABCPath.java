
package com.yahoo.twshopping.codejam;

public class ABCPath {
    
    public static final String path = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static final String F_FC = "First_Line_First_Char";
    public static final String F_LC = "First_Line_Last_Char";
    public static final String F_MC = "First_Line_Mid_Char";
    public static final String L_FC = "Last_Line_First_Char";
    public static final String L_LC = "Last_Line_Last_Char";
    public static final String L_MC = "Last_Line_Mid_Char";
    public static final String M_FC = "Middle_Line_First_Char";
    public static final String M_LC = "Middle_Line_Last_Char";
    public static final String M_MC = "Middle_Line_Mid_Char";
    
    public int length(String[] data) {
        int pathlen = 0; 
        int maxlen  = 0;
        int pathpos = 0;
        boolean hasNext = true;
        
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[i].length(); j++) {
                if (data[i].charAt(j) == path.charAt(pathpos)) {
                    pathlen++;
                    pathlen = findPathLength(data, i, j, pathpos, pathlen, hasNext);
                }
                if (pathlen > maxlen) {
                    maxlen = pathlen;
                }
                pathpos = 0; pathlen = 0;
            }
        }
        return maxlen;
    }    
    
    private String getPosition(String[] data, int line, int index) {
        String position = "";
        if ((line+1) == 1) { 
            if(index == 0)  position = F_FC;
            else if(index == data[line].length()-1)  position = F_LC;
            else position = F_MC;         
        } else if((line+1) == data.length) {
            if(index == 0)  position = L_FC; 
            else if(index == data[line].length()-1)  position = L_LC;
            else position = L_MC;
        } else {
            if(index == 0)  position = M_FC;
            else if(index == data[line].length()-1)  position = M_LC;
            else position = M_MC;
        }
        return position;
    }
    
    public int findPathLength(String[] matrix, int currentLine, int currentIndex, int pos, int len, boolean hasNext) {
        
        if (!hasNext || len==26) return len;
        else {
            switch(getPosition(matrix, currentLine, currentIndex)) {
            case F_FC:
                if(findRight(matrix, currentLine, currentIndex, pos))              {len++; pos++; currentIndex++; hasNext=true;}
                else if (findDown(matrix, currentLine, currentIndex, pos))         {len++; pos++; currentLine++;hasNext=true;}
                else if (findRightDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex++;hasNext=true;}
                else hasNext = false;                
                break;
            case F_LC:
                if(findLeft(matrix, currentLine, currentIndex, pos))              {len++; pos++; currentIndex--;hasNext=true;}
                else if (findDown(matrix, currentLine, currentIndex, pos))        {len++; pos++; currentLine++;hasNext=true;}
                else if (findLeftDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex--;hasNext=true;}
                else hasNext = false;                
                break;
            case F_MC:
                if(findRight(matrix, currentLine, currentIndex, pos))              {len++; pos++; currentIndex++;hasNext=true;} 
                else if(findLeft(matrix, currentLine, currentIndex, pos))          {len++; pos++; currentIndex--;hasNext=true;}
                else if (findDown(matrix, currentLine, currentIndex, pos))         {len++; pos++; currentLine++;hasNext=true;}
                else if (findRightDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex++;hasNext=true;}
                else if (findLeftDownDia(matrix, currentLine, currentIndex, pos))  {len++; pos++; currentLine++; currentIndex--;hasNext=true; }
                else hasNext = false;                
                break;
            case L_FC:
                if(findRight(matrix, currentLine, currentIndex, pos))            {len++; pos++; currentIndex++;hasNext=true;}
                else if (findUp(matrix, currentLine, currentIndex, pos))         {len++; pos++; currentLine--;hasNext=true;}
                else if (findRightUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex++;hasNext=true;}
                else hasNext = false;                
                break;
            case L_LC:
                if(findLeft(matrix, currentLine, currentIndex, pos))            {len++; pos++; currentIndex--;hasNext=true;}
                else if (findUp(matrix, currentLine, currentIndex, pos))        {len++; pos++; currentLine--;hasNext=true;}
                else if (findLeftUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex--;hasNext=true;}
                else hasNext = false;                
                break;
            case L_MC:
                if(findRight(matrix, currentLine, currentIndex, pos))            {len++; pos++; currentIndex++;hasNext=true;}
                else if(findLeft(matrix, currentLine, currentIndex, pos))        {len++; pos++; currentIndex--;hasNext=true;}
                else if (findUp(matrix, currentLine, currentIndex, pos))         {len++; pos++; currentLine--;hasNext=true;}
                else if (findLeftUpDia(matrix, currentLine, currentIndex, pos))  {len++; pos++; currentLine--; currentIndex--;hasNext=true;}                          
                else if (findRightUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex++;hasNext=true;}
                else hasNext = false;                
                break;
            case M_FC:
                if(findRight(matrix, currentLine, currentIndex, pos))              {len++; pos++; currentIndex++;hasNext=true;}
                else if (findDown(matrix, currentLine, currentIndex, pos))         {len++; pos++; currentLine++;hasNext=true;} 
                else if (findUp(matrix, currentLine, currentIndex, pos))           {len++; pos++; currentLine--;hasNext=true;}
                else if (findRightDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex++;hasNext=true;}
                else if (findRightUpDia(matrix, currentLine, currentIndex, pos))   {len++; pos++; currentLine--; currentIndex++;hasNext=true;}
                else hasNext = false;                
                break;
            case M_LC:
                if(findLeft(matrix, currentLine, currentIndex, pos))              {len++; pos++; currentIndex--;hasNext=true;} 
                else if (findDown(matrix, currentLine, currentIndex, pos))        {len++; pos++; currentLine++;hasNext=true;}
                else if (findUp(matrix, currentLine, currentIndex, pos))          {len++; pos++; currentLine--;hasNext=true;}
                else if (findLeftDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex--;hasNext=true;}
                else if (findLeftUpDia(matrix, currentLine, currentIndex, pos))   {len++; pos++; currentLine--; currentIndex--;hasNext=true;}
                else {hasNext = false;}                
                break;
            case M_MC:
                if(findRight(matrix, currentLine, currentIndex, pos))              {len++; pos++; currentIndex++;hasNext=true;} 
                else if(findLeft(matrix, currentLine, currentIndex, pos))          {len++; pos++; currentIndex--;hasNext=true;}
                else if (findDown(matrix, currentLine, currentIndex, pos))         {len++; pos++; currentLine++;hasNext=true;}
                else if (findUp(matrix, currentLine, currentIndex, pos))           {len++; pos++; currentLine--;hasNext=true;}
                else if (findRightDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex++;hasNext=true;}
                else if (findRightUpDia(matrix, currentLine, currentIndex, pos))   {len++; pos++; currentLine--; currentIndex++;hasNext=true;}
                else if (findLeftDownDia(matrix, currentLine, currentIndex, pos))  {len++; pos++; currentLine++; currentIndex--;hasNext=true;}
                else if (findLeftUpDia(matrix, currentLine, currentIndex, pos))    {len++; pos++; currentLine--; currentIndex--;hasNext=true;}
                else {hasNext = false;}                
                break;                
            }
            return findPathLength(matrix, currentLine, currentIndex, pos, len, hasNext);
        }
    }
    
    private boolean findRight(String[] matrix, int currentLine, int currentIndex, int pathpos) {
        if(matrix[currentLine].length() == (currentIndex+1))
            return false; // no right exists
        else {
            if(matrix[currentLine].charAt(currentIndex+1) == path.charAt(pathpos+1))
                return true;
            else 
                return false;            
        }
    }
    
    private boolean findLeft(String[] matrix, int currentLine, int currentIndex, int pathpos) {
        if(currentIndex == 0)
            return false; // no left exists
        else {
            if(matrix[currentLine].charAt(currentIndex-1) == path.charAt(pathpos+1))
                return true;
            else 
                return false;            
        }
    }
    
    private boolean findUp(String[] matrix, int currentLine, int currentIndex, int pathpos) {
        if(currentLine == 0)
            return false; //no up exist
        else {
            if (matrix[currentLine-1].charAt(currentIndex) == path.charAt(pathpos+1))
                return true;
            else 
                return false;            
        }
    }
    
    private boolean findDown(String[] matrix, int currentLine, int currentIndex, int pathpos) {
        if (matrix.length == (currentLine+1))
            return false; // no down exist
        else {
            if (matrix[currentLine+1].charAt(currentIndex) == path.charAt(pathpos+1))
                return true;
            else 
                return false;            
        }
    }
    
    private boolean findRightUpDia(String[] matrix, int currentLine, int currentIndex, int pathpos) {
        if ((matrix[currentLine].length() == (currentIndex+1)) || (currentLine == 0))
            return false;
        else {
            if (matrix[currentLine-1].charAt(currentIndex+1) == path.charAt(pathpos+1))  
                return true;
            else 
                return false;   
        }        
    }
    
    private boolean findRightDownDia(String[] matrix, int currentLine, int currentIndex, int pathpos) {
        if ((matrix[currentLine].length() == (currentIndex+1)) || (matrix.length == (currentLine+1)))
            return false;
        else {
            if (matrix[currentLine+1].charAt(currentIndex+1) == path.charAt(pathpos+1)) 
                return true;
            else 
                return false;            
        }
    }
    
    private boolean findLeftUpDia(String[] matrix, int currentLine, int currentIndex, int pathpos) {
        if ((currentIndex == 0) || (currentLine == 0))
            return false;
        else {
            if (matrix[currentLine-1].charAt(currentIndex-1) == path.charAt(pathpos+1)) 
                return true;
            else 
                return false;   
        }
    }
    
    private boolean findLeftDownDia(String[] matrix, int currentLine, int currentIndex, int pathpos) {
        if ((currentIndex == 0) || (matrix.length == (currentLine+1)))
            return false;
        else {
            if (matrix[currentLine+1].charAt(currentIndex-1) == path.charAt(pathpos+1)) 
                return true;
            else 
                return false;            
        }
    }
}
