import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastExample {

    public static void main(String[] args) {

        // Hazelcast sunucusuna bağlan
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();

        // "people" adında bir map (sözlük) oluştur
        IMap<Integer, Person> personMap = hz.getMap("people");

        // 10.000 adet Person nesnesi oluştur ve map'e ekle
        for (int i = 0; i < 10000; i++) {
            Person person = new Person("Kişi-" + i);
            personMap.put(i, person);
        }

        System.out.println("10.000 kişi eklendi.");

        // Map'ten kişileri geri al
        for (int i = 0; i < 10; i++) {
            Person person = personMap.get(i);
            System.out.println("ID: " + i + " | Ad: " + person.getName());
        }

        // Programı sonlandır
        hz.shutdown();
    }
}

