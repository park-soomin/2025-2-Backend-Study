- 스프링 계층형 아키텍처(Layered Architecture)
    Browser, Controller, Service, DAO, DB 계층으로 구성

    - 컨트롤러 계층(Controller Layer)
        HTTP 요청 / 응답
        특정 endpoint(URL)로 요청을 가장 먼저 처리
        DTO(Data Transfer Object)를 사용하여 서비스 계층(Service Layer)와 데이터 주고받음

        - 컨트롤러 계층 구현
            1. @Controller 어노테이션
            2. @Responsebody 어노테이션
            3. @RestController 어노테이션
            4. 생성자 주입(서비스 계층에 의존)
            5. @RequestMapping을 통해 method, url 지정
            6. 공통 URL & 상세 URL
            7. @RequestBody를 통해 json 데이터 받아오기

    - 서비스 계층(Service Layer)
        애플리케이션의 비즈니스 로직이 담기는 계층
        레포지토리 계층과 소통 (with 엔티티 or DTO)
        컨트롤러와 레포지토리 계층 사이의 중간 다리

        - 서비스 계층 구현
            1. 생성자 주입
            2. @transactional
            3. (readOnly = true) 옵션
            * 조회만 하는 경우, 트랜잭션 내에서 데이터가 변경되지 않도록 readOnly 속성 활성화

    - DTO
        꼭 필요한 정보만 포함
        데이터 전송 객체(Data Transfer Object)
        소통 목적에 맞는, 필요한 정보만 전달

    - Entity
        모든 정보 포함
        DB 테이블과 맵핑되는 핵심 객체
        외부 직접 노출 금지(데이터 일관성/보안)


- 패키지 구조: 계층형 vs 도메인형
    - 계층형 구조
        애플리케이션을 기능별로 나눔
        ex) com.example.shop
            |--- controller
            |    |--- MemberController.java
            |    |--- ProductController.java
            |    |--- OrderController.java
            |--- service

    - 도메인형 구조
        도메인 관련 모든 클래스를 포함
        코드 탐색 쉬움
        개발, 유지보수하기 용이
        새 도메인 추가 시 다른 곳에 영향 X
        ex) com.example.shop
            |--- member
            |    |--- controller
            |    |--- service
            |--- product
            

- 스프링(Spring)
    대표적인 Java 백엔드 애플리케이션 프레임워크

    - 스프링 빈(Spring Bean)
        어플리케이션 전역에서 사용할 공용 객체
        스프링 컨테이너에 빈을 저장, 필요한 빈을 컨테이너에서 받아 사용
        필요한 빈은 스프링 프레임워크가 자동으로 공급
        빈을 요구하는 객체 = 스프링 빈

        - 빈 등록 방법: 컴포넌트 스캔 (자동 등록)
            1. 컴포넌트 스캔 (@ComponentScan)
                @SpringBootApplication에 포함
            2. 컴포넌트 (@Component)
                @Controller, @Service, @Repository, @Entity 등에 포함
            -> 빈으로 등록하고 싶은 클래스에 @Component 붙이면 됨

        - 의존성 주입(Dependency Injection, DI)
            의존하는 객체를 직접 생성하지 않고 밖에서 주입받음
            매번 필요한 객체 생성 대신, 생성된 객체 사용하므로 메모리 효율적 사용 가능

            - 의존성 주입 방법
                1. 생성자 주입
                    1. 안전하게 final 선언
                        [final: 변수에 한 번만 값을 할당할 수 있게 하여 변경막음]
                    2. 생성자에 @Autowired 사용, 생성자 통해 빈 주입
                    3. 만약 생성자 하나만 있다면, @Autowired 생략 가능
                2. 필드 주입
                3. 수정자 주입 (세터 주입)

    - 스프링 컨테이너(Spring Container)
        스프링 빈 저장소
        어플리케이션 컨텍스트(Application Context)