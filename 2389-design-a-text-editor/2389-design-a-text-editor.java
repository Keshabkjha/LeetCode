class TextEditor {
    char buffer[];
    int left;
    int right;
    public TextEditor() {
        buffer = new char[800000];
        left = 0;
        right = buffer.length-1;
    }
    
    public void addText(String text) {
        for(char c : text.toCharArray()){
            buffer[left] = c;
            left++;
        }
    }
    
    public int deleteText(int k) {
        if(k>left)k=left;
        left-=k;
        return k;
    }
    
    public String cursorLeft(int k) {                
        k = Math.min(k,left);
        while(k>0){
            left--;k--;
            buffer[right] = buffer[left];
            right--;
        }
        int len = Math.min(10,left);
        StringBuilder sb = new StringBuilder();
        int i = left;
        while(len!=0){
            len--;i--;
            sb.append(buffer[i]);
        }
        return sb.reverse().toString();        
    }
    
    public String cursorRight(int k) {
        int charOnRight = buffer.length - right -1;
        k = Math.min(k,charOnRight);
        while(k>0){
            k--;
            right++;            
            buffer[left] = buffer[right];
            left++;
        }
        int len = Math.min(10,left);
        int i = left;
        StringBuilder sb = new StringBuilder();
        while(len!=0){
            len--;i--;
            sb.append(buffer[i]);
        }
        return sb.reverse().toString();

    }
}