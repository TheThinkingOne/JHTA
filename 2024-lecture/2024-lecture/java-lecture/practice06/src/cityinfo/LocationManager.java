package cityinfo;

import studentinfo.Student;

import java.util.*;

public class LocationManager {
    private Scanner sc = new Scanner(System.in);
    private HashMap<String, Location> cities = new HashMap<>();
    // 외부로부터 입력받아 학생 정보 여기서 입력
    private void read() {
        System.out.println("학생 정보를 입력하세요. 이름, 학과, 아이디, 학점평점 순");
        for (int i=0; i<4; i++) {
            System.out.println("입력시작===>");
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str,","); // 구분자로 ","를 구분해서 읽음

            String city = st.nextToken();
            double longitude = Double.parseDouble(st.nextToken());
            double latitude = Double.parseDouble(st.nextToken());
            Location location = new Location(city,longitude,latitude);

            cities.put(city,location);

        }

    }
    public void showAll() {
        for (String key:cities.keySet()) {
            Location location = cities.get(key);
            String city = location.getCity();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();

            System.out.printf("도시 : %s, 위도 : %.4f, 경도 : %.4f\n",city,longitude,latitude);

        }
        for(Map.Entry<String,Location> entry:cities.entrySet()) {
            String key = entry.getKey();
            Location location = entry.getValue();
            String city = location.getCity();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            System.out.printf("도시 : %s, 위도 : %.4f, 경도 : %.4f\n",city,longitude,latitude);
        }
    }

    public void query() {
        while (true) {
            System.out.println("검색할 도시");
            String selectedCity = sc.nextLine();
            if (selectedCity.equals("그만")) {
                System.out.println("프로그램 종료");
                break;
            }

            Location location = cities.get(selectedCity);
            if(location!=null) {
                String city = location.getCity();
                double longitude = location.getLongitude();
                double latitude = location.getLatitude();

                System.out.printf("도시 : %s, 위도 : %.4f, 경도 : %.4f\n",city,longitude,latitude);

            }
            else System.out.println("찾는 도시가 없습니다.");

        }
    }


    public void run() {
        read();
        showAll();
        query();
    }
}
