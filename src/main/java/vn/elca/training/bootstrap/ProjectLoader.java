package vn.elca.training.bootstrap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import vn.elca.training.dao.IEmployeeRepository;
import vn.elca.training.dao.IGroupRepository;
import vn.elca.training.dao.IProjectRepository;
import vn.elca.training.dom.Employee;
import vn.elca.training.dom.Group;
import vn.elca.training.dom.Project;
import vn.elca.training.model.Status;

@Component
public class ProjectLoader implements ApplicationListener<ContextRefreshedEvent> {
    private IProjectRepository projectRepository;
    private IGroupRepository groupRepository;
    private IEmployeeRepository memberRepository;

    @Autowired
    public void setGroupRepository(IGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Autowired
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setMemberRepository(IEmployeeRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private Logger log = Logger.getLogger(ProjectLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Group group = new Group("KTG");
        this.groupRepository.save(group);
        Employee member = new Employee("KIM", "KIM THY", "NGUYEN");
        this.memberRepository.save(member);
        List<Employee> members = new ArrayList<Employee>();
        members.add(member);
        Project dummyPrj = new Project(1, "KSTA", new Date(), Status.NEW, "Helm AG", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(2, "LAGAPEO", new Date(), Status.NEW, "Lanxess AG", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(3, "ZHQUEST", new Date(), Status.NEW, "Agravis Raiffeisen AG", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(4, "SECUTIX", new Date(), Status.NEW, "Les Retaitest Popularies", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(5, "Telekommunikation", new Date(), Status.NEW, "Volkswagen AG", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(6, "Pharma", new Date(), Status.INP, "E.ON SE", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(7, "Pharmahandel", new Date(), Status.INP, "BMW AG", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(8, "Energieversorger", new Date(), Status.INP, "Schwarz Beteiligungs GmbH", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(9, "Maschinenbau", new Date(), Status.INP, "BASF SE", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(10, "Touristik", new Date(), Status.INP, "Siemens AG", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(11, "Automobilzulieferer", new Date(), Status.PLA, "Deutsche Telekom AG", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(12, "Medien", new Date(), Status.PLA, "Deutsche Post DHL Group", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(13, "Finanzdienstleistungen", new Date(), Status.PLA, "Rewe Group", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(14, "Konsumgüter", new Date(), Status.FIN, "BP Europa SE", group);
        this.projectRepository.save(dummyPrj);
        dummyPrj = new Project(15, "Baustoffe", new Date(), Status.FIN, "Edeka Zentrale AG & Co. KG", group);
        this.projectRepository.save(dummyPrj);
        log.info("Init 15 dummy projects...");
    }
}
