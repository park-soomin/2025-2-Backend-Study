- 웹(Web)
    인터넷 위에서 동작하는 서비스중 하나
    인터넷에 연결된 전 세계 사용자들이 서로의 정보를 공유할 수 있는 장소

    - 클라이언트(client)
        요청(request)을 보내고, 서버의 응답 결과를 받아 사용
    - 서버(server)
        클라이언트의 요청을 받아 처리하고, 그에 대한 응답(response)을 반환

    - URL(Uniform Resource Locator)
        웹상에서 특정 자원의 위치를 나타내는 주소

        http://www.example.com:5883/category/food.html?topic=pizza

        Host : 리소스가 위치한 서버의 IP 주소 혹은 도메인
                (www.example.com)
        Port : 서버의 특정 네트워크 포트 번호 (일반적으로 생략)
                (:5883)
        Path : 서버 내에서 원하는 리소스의 경로
                (/category/food.html)
        Query : 서버에 추가적인 정보를 보내는 파라미터
                (?topic=pizza&size=large)
        Scheme(Protocol) : 장치들 사이에서 데이터를 주고 받는 방식
                            (http)


- HTTP
    웹에서 데이터를 주고받는 서버-클라이언트 모델의 프로토콜
    클라이언트의 요청(request)과 서버의 응답(response)을 통해 작동

    - HTTP 요청
    GET /test.html HTTP/1.1                 -> start line
    Host: google.com                        |-> headers
    Accept: text/html                       |
    Accept-Encoding: gzip, deflate          |
    Connection: keep-alive                  |

    hl=ko&ogbl=0&page=99                    -> body

        start line : 요청 메서드, 요청할 경로, HTTP 버전 정보
        headers : 요청에 대한 부가 정보
        body : 실제 전송 데이터

            - HTTP 주요 메서드
                GET : 리소스 조회
                POST : 리소스 추가, 등록
                PUT : 리소스 교체, 없으면 새로 생성
                PATCH : 리소스 일부 수정
                DELETE : 리소스 삭제

    - HTTP 응답
    HTTP/1.1 200 OK                         -> status line
    Date: Sun, 26 June ...                  |-> headers
    Server: Apache                          |
    Content-Length: 35                      |
    Content-Type: text/html                 |

    <h1>Hello World</h1>                    -> body

        status line : HTTP 버전, HTTP 상태 코드, 상태 메시지
        headers : 응답에 대한 부가 정보
        body : 실제 응답 데이터

            - HTTP 주요 상태 코드
                200 OK : 요청 성공적으로 처리
                201 Created : 요청 성공적으로 처리, 새로운 리소스 생성
                400 Bad Request : 클라이언트 요청 잘못됨, 서버 이해 X
                404 Not Found : 지정한 리소스 찾을 수 없음
                500 Internal Server Error : 서버 내부 오류로 요청 처리 X


- 프론트엔드(Front-end), 백엔드(Back-end)
    - 프론트엔드
    : 사용자가 직접 보고 상호작용하는 화면, 사용자 인터페이스(UI) 개발
    - 백엔드
    : 사용자의 요청을 받아 실제 동작을 처리하고 데이터 저장, 관리

    - 데이터베이스(Database, DB)
        데이터를 체계적으로 모아둔 저장소
        일반적으로 컴퓨터 시스템에 전자적 저장
        데이터베이스 관리 시스템(DBMS)으로 데이터베이스 관리, 조작
        대표적인 DBMS : MySQL, PostgreSQL, MongoDB


- API, REST API
    - API(Application Programming Interface)
        한 프로그램이 다른 프로그램의 기능이나 데이터를 사용할 수 있도록 미리 정해놓은 약속, 소통 창구

    - REST(Representational State Transfer)
        REST는 네트워크 아키텍처 스타일로, HTTP의 장점 최대한 활용할 수 있는 아키텍처

        - REST 구성 요소
            1. 자원(Resource) - URI
                모든 자원은 고유한 ID 가지며, 이 ID는 /student/1 같은 HTTP URI임
            2. 행위(Verb) - Method
                자원을 조작하기 위해 HTTP Method 사용
            3. 표현(Representation)
                서버와 클라이언트가 데이터를 주고 받는 형식, JSON 형식이 일반적

        - REST API
            자원(Resource)을 고유한 URI로 식별, 해당 자원(Verb)를 HTTP 메서드(GET, POST, PUT 등)로 정의, 그 결과를 JSON 같은 표준 형식으로 표현하는 웹 서비스 아키텍처 스타일

    즉, REST는 HTTP를 잘 활용하기 위한 원칙,
    REST API는 이 원칙을 준수해 만든 API이자 HTTP의 모범 사례


- 온라인 쇼핑몰 프로젝트 API 명세서 작성
    - 상품 기능
        - 상품 정보 등록
                HTTP method : POST
                URI : /products
        - 상품 목록 조회
                HTTP method : GET
                URI : /products
        - 개별 상품 정보 상세 조회
                HTTP method : GET
                URI : /products/1
        - 상품 정보 수정
                HTTP method : PATCH
                URI : /products/1
        - 상품 삭제
            HTTP method : DELETE
            URI : /products/1

    - 주문 기능
        - 주문 정보 생성
                HTTP method : POST
                URI : /order
        - 주문 목록 조회
                HTTP method : GET
                URI : /order
        - 개별 주문 정보 상세 조회
                HTTP method : GET
                URI : /order/1
        - 주문 취소
                HTTP method : DELETE
                URI : /order/1

