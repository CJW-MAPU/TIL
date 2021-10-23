books = [
    {'제목': '개발자의 코드', '출판연도': '2013.02.28', '출판사': 'A', '페이지 수': 200, '추천 유무': False},
    {'제목': '클린코드', '출판연도': '2010.03.04', '출판사': 'B', '페이지 수': 584, '추천 유무': True},
    {'제목': '빅데이터 마케팅', '출판연도': '2014.07.02', '출판사': 'A', '페이지 수': 296, '추천 유무': True},
    {'제목': '구글드', '출판연도': '2010.02.10', '출판사': 'B', '페이지 수': 526, '추천 유무': False},
    {'제목': '강의력', '출판연도': '2013.12.12', '출판사': 'A', '페이지 수': 248, '추천 유무': True}
]

# recommands = [book['제목'] for book in books if book['추천 유무']]
#
# all_pages = sum([book['페이지 수'] for book in books])
# pub_company = set([book['출판사'] for book in books])

many_page = []
recommands = []
all_pages = 0
pub_company = set()

print('전체 책 목록')
for book in books:
    print(book)
    if book['페이지 수'] > 250:
        many_page.append(book['제목'])

    if book['추천 유무']:
        recommands.append(book['제목'])

    all_pages += book['페이지 수']

    pub_company.add(book['출판사'])

print()
print(f'쪽수가 250 쪽 넘는 책 리스트: {many_page}')
print(f'내가 추천하는 책 리스트: {recommands}')
print(f'내가 읽은 책 전체 쪽수: {all_pages}')
print(f'내가 읽은 책의 출판사 목록: {pub_company}')
print()
many_page = [book['제목'] for book in books if book['페이지 수'] > 250]

print(f'한 줄로 만든 쪽수가 250 쪽 넘는 책 리스트: {many_page}')

