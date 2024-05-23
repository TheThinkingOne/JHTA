class DogxxException extends RuntimeException {
    // runtimeException은 실행 후 예외처리
    // exception 은 컴파일 단계에서 막음

}

public class ThrowException {
    public void sayHello(String msg) {
        try {
            if (msg.equals("시발련아") || (msg.equals("개새끼"))) {
                throw new DogxxException();
            }
            System.out.println("다함께 외쳐봐요..." + msg);
        } catch (DogxxException e) {
            System.out.println("DogxxException 이 발생했습니다");
        }

    }

    public static void main(String[] args) {
        ThrowException throwException = new ThrowException();
        throwException.sayHello("야호");
        throwException.sayHello("야호");
        throwException.sayHello("시발련아");
        throwException.sayHello("개새끼");

    }
}
