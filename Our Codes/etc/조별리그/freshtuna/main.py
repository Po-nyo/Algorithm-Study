import functools

class Solution:
  def __init__(self, *args, **kwargs):
    # 팀의 갯수
    self.team_count = 0
    # 팀정보 (이름과 인덱스를 매칭)
    self.team = {}
    # 가장 최근 전적
    self.latest_result = []
    # fight cases
    self.fights = []

  def input_init(self):
    import sys

    self.team_count = int(
      sys.stdin.readline().strip("\n"))

    for i in range(self.team_count):
      team_name = sys.stdin.readline().strip("\n")
      self.team[team_name] = {'index': i, 
        'win': 0, 'lose': 0, 'plus': 0, 'minus': 0}
    
    self.latest_result = [self.team_count * [0]
      ] * self.team_count

    self.fights = [fight_case.strip('\n') 
      for fight_case in sys.stdin]

  def call(self):
    for fight_case in self.fights:
      a, score, b = fight_case.split(" ")
      a_score, b_score = list(map(int, score.split(":")))
      self.set_scores(a, b, a_score, b_score)

    self.print(sorted(
      self.team.keys(), 
      key=functools.cmp_to_key(self.comparator)))

  def set_scores(self, a, b, a_score, b_score):
    a, b = self.team[a], self.team[b]

    a["plus"], a["minus"] = \
      a["plus"] + a_score,  a["minus"] - b_score
    b["plus"], b["minus"] =\
      b["plus"] + b_score, b["minus"] - a_score
    
    if a_score > b_score:
      a["win"], b["lose"] = a["win"] + 1, b["lose"] + 1
      self.latest_result[a["index"]][b["index"]] = 1
      self.latest_result[b["index"]][a["index"]] = -1
    else:
      b["win"], a["lose"] = b["win"] + 1, a["lose"] + 1
      self.latest_result[a["index"]][b["index"]] = -1
      self.latest_result[b["index"]][a["index"]] = 1
  
  def comparator(self, a, b):
    def compare_winning(a, b):
      a, b = a["win"], b["win"]
      return -1 if a > b else (1 if a < b else 0)

    def compare_plus_minus(a, b):
      a, b = a["plus"] + a["minus"], b["plus"] + b["minus"]
      return -1 if a > b else (1 if a < b else 0)

    def compare_latest_fight(a, b, latest_result):
      a_b = latest_result[a["index"]][b["index"]]
      b_a = latest_result[b["index"]][a["index"]]
      return -1 if a_b == 1 else (1 if b_a == 1 else 0)

    a, b = self.team[a], self.team[b]
    result = compare_winning(a, b)
    if result != 0: return result
    
    result = compare_plus_minus(a, b)
    if result != 0: return result

    return compare_latest_fight(a, b, self.latest_result)

  def print(self, sorted_teams):
    for rank in range(len(sorted_teams)):
      team_name = sorted_teams[rank]
      team_info = self.team[team_name]
      print(f'''{rank + 1}) {team_name} {
        team_info["win"]} {team_info["lose"]} {team_info["plus"]
        }{team_info["minus"]} {team_info["plus"] + team_info["minus"]}''')

if __name__ == "__main__":
  s = Solution()
  s.input_init()
  s.call()
