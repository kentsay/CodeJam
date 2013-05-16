
package com.yahoo.twshopping.codejam;

public class ABCPath {
    
    private final String path = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
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
    
    public int findPathLength(String[] matrix, int currentLine, int currentIndex, int pos, int len, boolean hasNext) {
        
        if (!hasNext || len==26) {
            return len;
        }
        else {
            if ((currentLine+1) == 1) { //first line
                if(currentIndex == 0) { //first char
                    if(findRight(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex++; hasNext=true;} // right
                    else if (findDown(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++;hasNext=true;}  // down
                    else if (findRightDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex++;hasNext=true;} //right down dia
                    else hasNext = false;
                
                }else if(currentIndex == matrix[currentLine].length()-1) { //last char
                    if(findLeft(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex--;hasNext=true;} // left
                    else if (findDown(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++;hasNext=true;}  // down
                    else if (findLeftDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex--;hasNext=true;} //left down dia
                    else hasNext = false;
                    
                }else { //mid char
                    if(findRight(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex++;hasNext=true;} // right
                    else if(findLeft(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex--;hasNext=true;} // left
                    else if (findDown(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++;hasNext=true;}  // down
                    else if (findRightDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex++;hasNext=true;} //right down dia
                    else if (findLeftDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex--;hasNext=true; } //left down dia
                    else hasNext = false;
                    
                }            
            } else if((currentLine+1) == matrix.length) { // last line
                if(currentIndex == 0) { //first char
                    if(findRight(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex++;hasNext=true;} //right
                    else if (findUp(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--;hasNext=true;}  //up
                    else if (findRightUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex++;hasNext=true;} // right up dia
                    else hasNext = false;
                    
                }else if(currentIndex == matrix[currentLine].length()-1) { //last char
                    if(findLeft(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex--;hasNext=true;} //left
                    else if (findUp(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--;hasNext=true;}  //up
                    else if (findLeftUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex--;hasNext=true;} // left up dia
                    else hasNext = false;
                    
                }else { //mid char
                    if(findRight(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex++;hasNext=true;} //right
                    else if(findLeft(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex--;hasNext=true;} //left
                    else if (findUp(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--;hasNext=true;}  //up
                    else if (findLeftUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex--;hasNext=true;} // left up dia                          
                    else if (findRightUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex++;hasNext=true;} // right up dia
                    else hasNext = false;
                    
                }
            } else { //middle line
                if(currentIndex == 0) { //first char
                    if(findRight(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex++;hasNext=true;} // right
                    else if (findDown(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++;hasNext=true;}  // down
                    else if (findUp(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--;hasNext=true;}  //up
                    else if (findRightDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex++;hasNext=true;} //right down dia
                    else if (findRightUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex++;hasNext=true;} //right up dia
                    else hasNext = false;
                    
                }else if(currentIndex == matrix[currentLine].length()-1) { //last char
                    if(findLeft(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex--;hasNext=true;} // left
                    else if (findDown(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++;hasNext=true;}  // down
                    else if (findUp(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--;hasNext=true;}  //up
                    else if (findLeftDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex--;hasNext=true;} //left down dia
                    else if (findLeftUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex--;hasNext=true;} //left up dia
                    else {hasNext = false;}
                    
                }else { //mid char
                    if(findRight(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex++;hasNext=true;} // right
                    else if(findLeft(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentIndex--;hasNext=true;} // left
                    else if (findDown(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++;hasNext=true;}  // down
                    else if (findUp(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--;hasNext=true;}  //up
                    else if (findRightDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex++;hasNext=true;} //right down dia
                    else if (findRightUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex++;hasNext=true;} //right up di
                    else if (findLeftDownDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine++; currentIndex--;hasNext=true;} //left down dia
                    else if (findLeftUpDia(matrix, currentLine, currentIndex, pos)) {len++; pos++; currentLine--; currentIndex--;hasNext=true;} //left up dia
                    else {hasNext = false;}
                }
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