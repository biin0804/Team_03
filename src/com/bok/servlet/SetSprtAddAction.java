package com.bok.servlet; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.SprtContentVO;
import com.bok.model.SprtPersonVO;
import com.bok.service.SprtManagerService;

public class SetSprtAddAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("sprtTitle");
        String summary = request.getParameter("sprtSummary");
        String link = request.getParameter("sprtLink");
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");

        // PK ���� �޾ƿ���
        String fkSprtNum = request.getParameter("fkSprtNum");
        String sprtpNum = request.getParameter("sprtpNum");

        String[] subtitles = request.getParameterValues("sprtSubTitleList");
        String[] contents = request.getParameterValues("sprtTextList");

        SprtPersonVO person = new SprtPersonVO();
        person.setTitle(title);
        person.setSummary(summary);
        person.setLink(link);
        person.setStart(start);
        person.setEnd(end);

        // PK �� ����
        person.setFkSprtNum(fkSprtNum != null ? Integer.parseInt(fkSprtNum) : 0);
        person.setSprtpNum(sprtpNum != null ? Integer.parseInt(sprtpNum) : 0);

        List<SprtContentVO> contentList = new ArrayList<>();
        if (subtitles != null && contents != null) {
            for (int i = 0; i < subtitles.length; i++) {
                SprtContentVO content = new SprtContentVO();
                content.setSubtitle(subtitles[i]);
                content.setContent(contents[i]); 
                content.setFkSprtpNum(person.getSprtpNum()); 
                contentList.add(content);
            }
        }

        // ���� ȣ��
        SprtManagerService service = new SprtManagerService();
        boolean success = service.setAddSprt(person, contentList);

        if (success) {
            return "sprtManagerUI.jsp"; 
        } else {
//            request.setAttribute("person", person);
//            request.setAttribute("contentList", contentList);
            request.setAttribute("message", "��� ����!");
            return "tm.jsp"; 
        }
    }
}
