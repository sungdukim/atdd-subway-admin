package nextstep.subway.line.ui;

import nextstep.subway.line.application.SectionService;
import nextstep.subway.line.dto.SectionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lines/{lineId}")
public class SectionController {

    private final SectionService sectionService;

    public SectionController(final SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping("/sections")
    public ResponseEntity<Void> addSection(
        @PathVariable final Long lineId,
        @RequestBody final SectionRequest request
    ) {
        sectionService.addSection(lineId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/sections")
    public ResponseEntity<Void> removeLineStation(
        @PathVariable Long lineId,
        @RequestParam Long stationId
    ) {
        sectionService.removeSectionByStationId(lineId, stationId);
        return ResponseEntity.ok().build();
    }
}
