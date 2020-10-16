class Solution
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
    self.team_count = int(
      sys.stdin.readline().strip("\n"))

    for i in range(self.team_count):
      setattr(self.team, 
        sys.stdin.readline().strip("\n"), 
        {'index': i, 
          'win': 0, 'lose': 0, 'plus': 0, 'minus': 0})
    
    self.latest_result = [self.team_count * [0]
      ] * self.team_count

    self.fights = [fight_case.strip('\n') 
      for fight_case in sys.stdin]

  def set_scores(self, a, b, a_score, b_score):
    a, b = self.teams[a], self.teams[b]

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
  
  def compare_latest_fight(a, b):
    def compare_winning(a, b)
      if a["win"] > b["win"]: return 1
      elif a["win"] < b["win"]: return -1
      else return 0

    def compare_plus_minus(a, b)
      a_plus_minus = a["plus"] + a["minus"]
      b_plus_minus = b["plus"] + b["minus"]

      if a_plus_minus > b_plus_minus: return 1
      elif a_plus_minus < b_plus_minus: return -1
      else return 0

    def compare_latest_fight(a, b, latest_result)
      a, b = a["index"], b["index"]
      if latest_result[a][b] == 1: return 1
      elif latest_result[b][a] == 1: return -1
      else return 0
 
    result = compare_winning(a, b)
    if result != 0: return result
    
    result = compare_plus_minus(a, b)
    if result != 0: return result

    return compare_latest_fight(a, b, self.latest_result)

  def print(self, sorted_teams):
    for k, v in sorted_teams.items():
      print(k)

  def call(self):
    for fight_case in self.fights:
      a, score, b = fight_case.split(" ")
      a_score, b_score = list(map(int, score.split(":")))
      self.set_scores(a, b, a_score, b_score)
      self.print({k: v for k, v in sorted(
        self.team.items(), 
        key=cmp_to_key(compare_latest_fight))})

