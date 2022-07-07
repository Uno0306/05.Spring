package com.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.dto.DiaryDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService{
	
//	@Autowired	// 의존성 주입
	private final DiaryRepository diaryRepo;
	
	@Transactional
	@Override
	public void insertDiary(DiaryDTO diaryDTO) {
		Diary diaryEntity  = diaryDTO.toEntity(diaryDTO);
		
		diaryRepo.save(diaryEntity);
	};
	
	@Transactional
	@Override
	public void insertDiaryBatch(List<DiaryDTO> diaryDTOList) {
		
		
//		List<Diary> diaryEntityList = new ArrayList<Diary>();
		/* ver 1 */
//		for(DiaryDTO diaryDTO : diaryDTOList) {
//			diaryEntityList.add(diaryDTO.toEntity(diaryDTO));
//		}

		/* ver 2 */
//		diaryDTOList.forEach(diaryDTO -> diaryEntityList.add(diaryDTO.toEntity(diaryDTO)));
		
		/* my ver */
//		IntStream.range(0, diaryDTOList.size()).forEach(i -> {
//			diaryEntityList.add(diaryDTOList.get(i).toEntity(diaryDTOList.get(i)));
//		});
		
		/* ver 3 */
		List<Diary> diaryEntityList = diaryDTOList.stream()
												.map(diaryDTO -> diaryDTO.toEntity(diaryDTO))
												.collect(Collectors.toList());
		
		diaryRepo.saveAll(diaryEntityList);
	};
}
