import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShippingService {
    public static void process(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        Map<String, List<Shippable>> grouped = items.stream()
                .collect(Collectors.groupingBy(Shippable::getName));

        double totalWeight = 0;

        for (Map.Entry<String, List<Shippable>> entry : grouped.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue().size();
            double totalProductWeight = entry.getValue().stream()
                    .mapToDouble(Shippable::getWeight).sum();

            System.out.printf("%dx %-12s %.0fg\n", count, name, totalProductWeight * 1000);
            totalWeight += totalProductWeight;
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
