package sof03.craftshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sof03.craftshop.domain.HandicraftRepository;
import sof03.craftshop.domain.Handicraft;

@SpringBootApplication
public class CraftshopApplication {
	private static final Logger log = LoggerFactory.getLogger(CraftshopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CraftshopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner handicrafts(HandicraftRepository handicraftRepository) {
		return (args) -> {
			log.info("save handicrafts");
			Handicraft handicraft1 = new Handicraft("Socks", "100% wool socks. Comfy for winter!", 10L);
			handicraftRepository.save(handicraft1);
			Handicraft handicraft2 = new Handicraft("Crochet top", "80% wool cool top for everyday wear", 30L);
			handicraftRepository.save(handicraft2);
			for (Handicraft handicraft : handicraftRepository.findAll()) {
				log.info(handicraft.toString());
			}
		};
	
	}
}
