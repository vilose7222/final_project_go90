package com.ezen.go90.web.vote.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.go90.domain.member.dto.Member;
import com.ezen.go90.domain.vote.dto.Vote;
import com.ezen.go90.domain.vote.dto.VoteResult;
import com.ezen.go90.domain.vote.service.VoteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



/**
 * 투표 관련 웹 요청을 처리하는 세부 컨트롤러 구현 클래스
 *
 * @author 윤동진
 * @since  2023. 9. 18.
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/vote")
@Slf4j
public class VoteController {

	private final VoteService voteService;
	
	@GetMapping("")
	public String voteForm(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginMember");
		String memberId = member.getMemberId();
	
		List<VoteResult> attendMember = voteService.findVoteByMemberId(memberId);
		session.setAttribute("attendMember", attendMember);
				for (VoteResult voteResult : attendMember) {
					System.out.println(voteResult);
				}
		List<Vote> list = voteService.loadVote();
		model.addAttribute("voteList",list);
		Vote votes = new Vote();
		model.addAttribute("votes",votes);
		return "board/vote";
	}
	
	@PostMapping("/create")
	public String registVote(@ModelAttribute("votes") Vote votes, Model model) {
        voteService.registVote(votes);
        voteService.connectPlan(votes); //0923 추가됨
		return "redirect:/vote";
	}
	
	@PostMapping("/attend")
	public String attend(@RequestParam("voteId") int voteId,
			 HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		
	    List<VoteResult> attendMember = (List<VoteResult>) session.getAttribute("attendMember");
	    for (VoteResult result : attendMember) {
	        if (result.getVoteId() == voteId) {
	            voteService.cancelVote(memberId, voteId);
	            return "redirect:/vote";
	        }
	    }
	    VoteResult voteresult = VoteResult.builder()
	            .memberId(memberId)
	            .voteId(voteId)
	            .build();
	    voteService.doVote(voteresult);
	    return "redirect:/vote";
	}
}
